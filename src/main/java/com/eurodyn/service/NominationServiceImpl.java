package com.eurodyn.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NominationServiceImpl {

    // create and update should verify 2 things
    // 1. there is no same actor for same year and genre of nomination
    // 2. there is only 1 WON result for same year and genre
    // 3. we are making th year/genre/actor but only logically not defined in schema
    

}
