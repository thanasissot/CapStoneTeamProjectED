//package com.eurodyn.controller.people;
//import com.eurodyn.model.people.CrewMember;
//import com.eurodyn.service.people.CrewMemberService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/crewMember")
//public class CrewMemberController {
//
//    private final CrewMemberService crewMemberService;
//
//    @PostMapping("/create")
//    public CrewMember createCrewMember(@RequestBody CrewMember crewMember) {
//
//        return crewMemberService.create(crewMember);
//    }
//
//    @GetMapping()
//    public List<CrewMember> readCrewMember() {
//        return crewMemberService.read();
//    }
//
//    @GetMapping("/{crewMemberId}")
//    public CrewMember getCrewMember(@PathVariable long crewMemberId) {
//        return crewMemberService.read(crewMemberId);
//    }
//
//    @PutMapping("/{crewMemberId}")
//    public CrewMember updateCrewMember(@PathVariable long crewMemberId, @RequestBody CrewMember newCrewMember) {
//        return crewMemberService.update(crewMemberId, newCrewMember);
//    }
//
//
//    @DeleteMapping("/{crewMemberId}")
//    public CrewMember deleteCrewMember(@PathVariable long crewMemberId) {
//        return crewMemberService.delete(crewMemberId);
//    }
//
//
//}
