package com.prem.quizapp.controller;

import com.prem.quizapp.model.Question;
import com.prem.quizapp.model.QuestionWrapper;
import com.prem.quizapp.model.Response;
import com.prem.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);

    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>  getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}
