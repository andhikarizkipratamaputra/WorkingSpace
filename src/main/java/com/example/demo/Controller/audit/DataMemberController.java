package com.example.demo.Controller.audit;


import com.example.demo.Model.audit.DataMember;
import com.example.demo.Repository.DataMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("datamember")
public class DataMemberController {

    @Autowired
    DataMemberRepository dataMemberRepository;

    @GetMapping()
    public ModelAndView index(ModelAndView mView){
        List<DataMember> dataMemberList = dataMemberRepository.findAll();
        mView.addObject("dataMemberList", dataMemberList);
        mView.setViewName("pages/datamember/index");
        return mView;
    }

    @GetMapping("/tambah")
    public String add(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute (name = "result_code") String result_message){
        if (!model.containsAttribute("data")){
            model.addAttribute("data",new DataMember());
        }

        return "pages/datamember/add";
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute(name = "data") DataMember dataMember,
                               BindingResult result, ModelAndView mView,
                               RedirectAttributes redirectAttributes){


        dataMemberRepository.save(dataMember);
        mView.setViewName("redirect:/datamember");
        return mView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid DataMember dataMember,
                         BindingResult result, Model model,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "redirect:/update";
        }
        DataMember dataMemberObj = dataMemberRepository.findById(id).get();
        dataMember.setId(dataMemberObj.getId());

        dataMemberRepository.save(dataMember);

        return "redirect:/datamember";
    }


    @GetMapping("/show/{id}")
    public ModelAndView show (@PathVariable("id") Long id, ModelAndView mView) {
        DataMember dataMember = dataMemberRepository.findById(id).get();
        mView.addObject("dataMember",dataMember);
        mView.setViewName("pages/datamember/show");
        return mView;
    }

    @GetMapping("/laporan")
    public ModelAndView laporan(ModelAndView mView){
        List<DataMember> dataMemberList = dataMemberRepository.findAll();
        mView.addObject("dataMemberList", dataMemberList);
        mView.setViewName("pages/datamember/laporan");
        return mView;
    }



    @GetMapping("/edit/{id}")
    public ModelAndView editDataMember (@PathVariable("id") Long id, ModelAndView mView) {
        DataMember dataMember = dataMemberRepository.findById(id).get();
        mView.addObject("dataMember",dataMember);
        mView.setViewName("pages/datamember/edit");
        return mView;
    }

    @GetMapping("/delete/{id}")
    public String deleteDataMember(@PathVariable("id") Long id, Model model) {
        DataMember dataMember = dataMemberRepository.findById(id).get();
        dataMemberRepository.delete(dataMember);
        model.addAttribute("datamember", dataMemberRepository.findAll());
        return "redirect:/datamember";
    }

}
