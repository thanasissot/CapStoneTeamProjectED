package com.eurodyn.service.people;

import com.eurodyn.model.people.CrewMember;
import com.eurodyn.repository.CrewMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CrewMemberServiceImpl implements CrewMemberService {
    private final CrewMemberRepository crewMemberRepository;

    @Override
    public CrewMember create(CrewMember crewMember) {
        return crewMemberRepository.save(crewMember);
    }

    @Override
    public List<CrewMember> read() {
        return crewMemberRepository.findAll();
    }

    @Override
    public CrewMember read(Long crewMemberId) {
        return crewMemberRepository.findById(crewMemberId).orElse(null);
    }

    @Override
    public CrewMember update(Long crewMemberId, CrewMember newCrewMember) {
        newCrewMember.setId(crewMemberId);
        return create(newCrewMember);
    }

    @Override
    public CrewMember delete(Long crewMemberId) {
        CrewMember crewMember = read(crewMemberId);
        if (crewMember == null) {
            return null;
        }
        crewMemberRepository.delete(crewMember);
        return crewMember;
    }
}
