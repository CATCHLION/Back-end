package com.example.mbti.Controller;

import ch.qos.logback.core.model.Model;
import com.example.mbti.Domain.Mbti;
import com.example.mbti.Req.MbtiInsert;
import com.example.mbti.Req.MbtiReq;
import com.example.mbti.Res.MbtiRes;
import com.example.mbti.Service.MbtiService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
public class MbtiController {
    private final MbtiService mbtiService;

    public MbtiController(MbtiService mbtiService){
        this.mbtiService = mbtiService;
    }

    @GetMapping("/home")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    /*
    @PostMapping("/mbti")
    public void saveMbti(@RequestBody MbtiInsert req){
        mbtiService.saveMbti(req);
    }
    */
    @GetMapping("/mbti")
    public List<MbtiRes> getMbtis(){
        return mbtiService.getMbtis();
    }

    /*
    @PostMapping("/mbtiw")
    public Mbti getMbti(@RequestBody MbtiReq req){
        return mbtiService.getMbti(req.getMbtiw());
    }
    */


    @PostMapping("/mbtiw")
    public ModelAndView getMbti(MbtiReq req){
        String a = mbtiService.getMbti(req.getMbtiw()).getInfo();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", req.getMbtiw() + " : " + a);
        modelAndView.setViewName("result");
        //modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/mbti")
    public ModelAndView saveMbti(HttpServletRequest httpServletRequest, Model model){


        String mbtiw = httpServletRequest.getParameter("mbtiw");
        String info = httpServletRequest.getParameter("info");

        mbtiService.saveMbti(mbtiw, info);

        System.out.println(mbtiw + "---- " + info + " ---- :");

        List<MbtiRes> a = mbtiService.getMbtis();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", mbtiw + " : " + info);
        modelAndView.setViewName("result");
        //modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView getMbtiss(){
        List<MbtiRes> a = mbtiService.getMbtis();
        StringBuilder sb = new StringBuilder();

        String arr[][] = new String[a.size()][2];

        for(int i=0; i<a.size(); i++){
            sb.append(a.get(i).getMbti()).append(" : ").append(a.get(i).getInfo()).append("   ");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", sb);
        modelAndView.setViewName("result");
        //modelAndView.setViewName("home");
        return modelAndView;
    }


}

