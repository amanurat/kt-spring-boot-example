package com.rtsup.api

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView


@RestController
class IndexController {

   //RequestMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

}
