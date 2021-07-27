package com.example.demo.Controller.audit;


import com.example.demo.Model.audit.DataMeja;
import com.example.demo.Model.audit.DataMember;
import com.example.demo.Model.audit.TempatTersewa;
import com.example.demo.Repository.DataMejaRepository;
import com.example.demo.Repository.DataMemberRepository;
import com.example.demo.Repository.TempatTersewaRepository;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("tempattersewa")
public class TempatTersewaController {
    @Autowired
    DataMemberRepository dataMemberRepository;

    @Autowired
    DataMejaRepository dataMejaRepository;

    @Autowired
    TempatTersewaRepository tempatTersewaRepository;

    @GetMapping()
    public ModelAndView index(ModelAndView mView){
        List<TempatTersewa> tempatTersewaList = tempatTersewaRepository.findAll();
        mView.addObject("tempatTersewaList", tempatTersewaList);
        mView.setViewName("pages/tempattersewa/index");
        return mView;
    }

    @GetMapping("/tambah")
    public String add (Model model,
                       @ModelAttribute(name = "result_code") String result_code,
                       @ModelAttribute(name = "result_message") String result_message) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", new TempatTersewa());
        }

        List<DataMember> dataMemberList = dataMemberRepository.findAll();
        model.addAttribute("DataMemberList", dataMemberList);

        List<DataMeja> dataMejaList = dataMejaRepository.findAll();
        model.addAttribute("DataMejaList", dataMejaList);

        return "pages/tempattersewa/add";
    }


    @PostMapping("/create")
    public ModelAndView create (@Valid @ModelAttribute(name = "data") TempatTersewa tempatTersewa,
                                BindingResult result, ModelAndView mView,
                                RedirectAttributes redirectAttributes,
                                @RequestParam("JamAwal") String JamAwalString,
                                @RequestParam("JamAkhir") String JamAkhirString)  throws ParseException, IOException, WriterException{

        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date JamAwal = sdft.parse(JamAwalString);

        SimpleDateFormat sdftt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date JamAkhir = sdftt.parse(JamAkhirString);

        tempatTersewa.setJamAwal(JamAwal);
        tempatTersewa.setJamAkhir(JamAkhir);
        tempatTersewa.setAvailable(false);
        tempatTersewaRepository.save(tempatTersewa);
        mView.setViewName("redirect:/tempattersewa");
        return mView;
    }

    @GetMapping("/laporan")
    public ModelAndView laporan (ModelAndView mView){
        List<TempatTersewa> tempatTersewaList = tempatTersewaRepository.findAll();
        mView.addObject("tempattersewaList",tempatTersewaList);
        mView.setViewName("pages/tempattersewa/laporan");
        return mView;
    }


    @GetMapping("/delete/{id}")
    public String deleteTempatTersewa(@PathVariable("id") Long id, Model model) {
        TempatTersewa tempatTersewa = tempatTersewaRepository.findById(id).get();
        tempatTersewaRepository.delete(tempatTersewa);
        model.addAttribute("tempattersewa", tempatTersewaRepository.findAll());
        return "redirect:/tempattersewa";
    }





}
