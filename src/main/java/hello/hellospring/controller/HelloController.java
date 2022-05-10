package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    // get 방식
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";     // resources/temmplates/hello.html 찾아서 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    
    @GetMapping("hello-string")
    @ResponseBody   // HTTP 바디 부분에 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring", 페이지에서 소스를 보면 태그가 없음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체를 반환하고 @ResponseBody를 쓰면 JSON 방식으로 반환하는게 기본
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
