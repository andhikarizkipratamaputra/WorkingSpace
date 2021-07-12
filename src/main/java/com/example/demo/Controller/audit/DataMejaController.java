package com.example.demo.Controller.audit;


import com.example.demo.Model.audit.DataMeja;
import com.example.demo.Repository.DataMejaRepository;
import com.example.demo.Util.QRCodeGenerator;
import com.example.demo.Util.Token;
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
import java.util.List;


@Controller
@RequestMapping("datameja")
public class DataMejaController {

    @Autowired
    DataMejaRepository dataMejaRepository;



    @GetMapping()
    public ModelAndView index(ModelAndView mView){
        List<DataMeja> dataMejaList = dataMejaRepository.findAll();
        mView.addObject("dataMejaList",dataMejaList);
        mView.setViewName("pages/datameja/index");
        return mView;
    }

    @GetMapping("/tambah")
    public String add(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute (name = "result_code") String result_message){
        if (!model.containsAttribute("data")){
            model.addAttribute("data",new DataMeja());
        }

        return "pages/datameja/add";
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute(name = "data") DataMeja dataMeja,
                               BindingResult result, ModelAndView mView,
                               RedirectAttributes redirectAttributes) throws IOException, WriterException {





        String token = Token.randomAlphaNumeric(10);
        dataMeja.setKodeMeja(token);
        dataMejaRepository.save(dataMeja);

        //ini untuk Generate QR CODE
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
        qrCodeGenerator.generateQRCodeImage(token);
        mView.setViewName("redirect:/datameja");
        return mView;
    }


    @GetMapping("/show/{id}")
    public ModelAndView show (@PathVariable("id") Long id, ModelAndView mView) {
        DataMeja dataMeja = dataMejaRepository.findById(id).get();
        mView.addObject("dataMeja",dataMeja);
        mView.setViewName("pages/datameja/show");
        return mView;
    }


    @GetMapping("/laporan")
    public ModelAndView laporan(ModelAndView mView){
        List<DataMeja> dataMejaList = dataMejaRepository.findAll();
        mView.addObject("dataMejaList", dataMejaList);
        mView.setViewName("pages/datameja/laporan");
        return mView;
    }

    @GetMapping("/delete/{id}")
    public String deleteDataMeja(@PathVariable("id") Long id, Model model) {
        DataMeja dataMeja = dataMejaRepository.findById(id).get();
        dataMejaRepository.delete(dataMeja);
        model.addAttribute("datameja", dataMejaRepository.findAll());
        return "redirect:/datameja";
    }







}
