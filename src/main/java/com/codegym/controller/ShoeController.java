package com.codegym.controller;

import com.codegym.model.Shoe;
import com.codegym.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/shoes")
public class ShoeController {

    @Autowired
    ShoeService shoeService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createShoe() {
        ModelAndView mav = new ModelAndView("shoe/create");
        mav.addObject("sShoe", new Shoe());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Shoe createShoe(@RequestBody Shoe shoe) {
        return shoeService.save(shoe);
    }

    //list
    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Shoe> allShoe(@PageableDefault(size = 5) Pageable pageable) {
        return shoeService.findAll(pageable);
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("shoe/list");

        modelAndView.addObject("allshoes", allShoe(Pageable.unpaged()));
        return modelAndView;
    }
//    public ModelAndView listShoe(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5) Pageable pageable) {
//        Page<Shoe> shoes;
//        if (s.isPresent()) {
//            shoes = shoeService.findAllByNameContaining(s.get(), pageable);
//        } else {
//            shoes = shoeService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("shoe/list");
//        modelAndView.addObject("allshoes", shoes);
//        return modelAndView;
//    }

    //	Delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Shoe deleteShoe(@PathVariable Integer id) {
        return shoeService.remove(id);
    }

    //Edit
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editShoe(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("shoe/edit");
        Shoe shoe = shoeService.findById(id);
        mav.addObject("sShoe", shoe);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Shoe editShoe(@PathVariable int id,
                         @RequestBody Shoe shoe) {
        shoe.setId(id);
        return shoeService.save(shoe);
    }

}
