package com.example.demo.Controller.audit;

import com.example.demo.Model.audit.DataBiaya;
import com.example.demo.Model.audit.DataMeja;
import com.example.demo.Model.audit.DataMember;
import com.example.demo.Repository.DataBiayaRepository;
import com.example.demo.Repository.DataMejaRepository;
import com.example.demo.Repository.DataMemberRepository;
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
@RequestMapping("databiaya")
public class DataBiayaController {
    @Autowired
    DataBiayaRepository dataBiayaRepository;

    @Autowired
    DataMemberRepository dataMemberRepository;

    @Autowired
    DataMejaRepository dataMejaRepository;

    @GetMapping()
    public ModelAndView index(ModelAndView mView){
        List<DataBiaya> dataBiayaList = dataBiayaRepository.findAll();
        mView.addObject("dataBiayaList", dataBiayaList);
        mView.setViewName("pages/databiaya/index");
        return mView;
    }


    @GetMapping("/tambah")
    public String add(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute(name = "result_message") String result_message) {
        // put default data for ${object} on form is there's no default
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", new DataBiaya());
        }
        List<DataMember> dataMemberList = dataMemberRepository.findAll();
        model.addAttribute("DataMemberList", dataMemberList);

        List<DataMeja> dataMejaList = dataMejaRepository.findAll();
        model.addAttribute("DataMejaList", dataMejaList);

        return "pages/databiaya/add";
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute(name = "data") DataBiaya dataBiaya,
                               BindingResult result, ModelAndView mView,
                               RedirectAttributes redirectAttributes,
                               @RequestParam("JamSewa") String JamSewaString,
                               @RequestParam("JamSelesai") String JamSelesaiString) throws ParseException, IOException, WriterException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date JamSewa = sdf.parse(JamSewaString);

        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date JamSelesai = sdff.parse(JamSelesaiString);

        dataBiaya.setJamSewa(JamSewa);
        dataBiaya.setJamSelesai(JamSelesai);
        dataBiayaRepository.save(dataBiaya);
        mView.setViewName("redirect:/databiaya");
        return mView;
    }


    @GetMapping("/show/{id}")
    public ModelAndView show (@PathVariable("id") Long id, ModelAndView mView) {
        DataBiaya dataBiaya = dataBiayaRepository.findById(id).get();
        mView.addObject("dataBiaya",dataBiaya);
        mView.setViewName("pages/databiaya/show");
        return mView;
    }



    @GetMapping("/delete/{id}")
    public String deleteDataBiaya(@PathVariable("id") Long id, Model model) {
        DataBiaya dataBiaya = dataBiayaRepository.findById(id).get();
        dataBiayaRepository.delete(dataBiaya);
        model.addAttribute("databiaya", dataBiayaRepository.findAll());
        return "redirect:/databiaya";
    }


    @GetMapping("/laporan")
    public ModelAndView laporan(ModelAndView mView){
        List<DataBiaya> dataBiayaList = dataBiayaRepository.findAll();
        mView.addObject("dataBiayaList", dataBiayaList);
        mView.setViewName("pages/databiaya/laporan");
        return mView;
    }








}
