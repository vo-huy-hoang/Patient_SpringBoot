package org.example.patient.controller;

import org.example.patient.dto.CustomerSearchDTO;
import org.example.patient.dto.ReExaminationCreateDTO;
import org.example.patient.mapper.ReExaminationMapper;
import org.example.patient.model.*;
import org.example.patient.service.*;
import org.example.patient.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    @Qualifier("reExaminationService")
    private IReExaminationService reExaminationService;
    @Autowired
    @Qualifier("typeOfBeautifyService")
    private ITypeOfBeautifyService typeOfBeautifyService;
    @Autowired
    @Qualifier("customerService")
    private ICustomerService customerService;
    @Autowired
    @Qualifier("locationService")
    private ILocationService locationService;
    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;
    @Autowired
    private ReExaminationMapper reExaminationMapper;

    @ModelAttribute("locationList")
    public List<Location> getlocationList() {
        return locationService.findAll();
    }
    @ModelAttribute("customerList")
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }
    @ModelAttribute("doctorList")
    public List<Doctor> getDoctorList() {
        return doctorService.findAll();
    }

    @GetMapping("/create")
    public String showCreate (Model model) {
        model.addAttribute("reExaminationCreateDTO", new ReExaminationCreateDTO());
        return "customer/create";
    }
    @GetMapping("/view")
    public String viewCustomer(Model model, Integer id, ReExamination reExamination) {
        List<ReExamination> reExaminationList = reExaminationService.findByCustomer_Id(id);
        model.addAttribute("reExamination",reExamination);
        model.addAttribute("reExaminationList", reExaminationList);
        return "customer/view";
    }
    @GetMapping("/delete")
    public String deleteCustomer(Integer id, RedirectAttributes redirectAttributes) {
//        customerService.delete(customerService.findById(id));
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        return "redirect:/customers";
    }
    @PostMapping("/create")
    public String createReExamination(Model model, @Validated @ModelAttribute("reExaminationCreateDTO") ReExaminationCreateDTO reExaminationCreateDTO, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new ReExaminationCreateDTO().validate(reExaminationCreateDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("reExaminationCreateDTO", reExaminationCreateDTO);
            return "customer/create";
        }
        ReExamination reExamination = reExaminationMapper.toReExaminationFromReExaminationCreateDTO(reExaminationCreateDTO);
        reExaminationService.save(reExamination);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/customers";
    }
    @GetMapping("")
    public String showList(Model model, CustomerSearchDTO customerSearchDTO, @PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customerList = customerService.search(customerSearchDTO, pageable);
        model.addAttribute("customerSearchDTO", customerSearchDTO);
        model.addAttribute("customerList", customerList);
        model.addAttribute("arrayPage", new int[customerList.getTotalPages()]);
        model.addAttribute("sort", pageable.getSort().toString().replace(": ", ","));
        return "customer/list";
    }
}
