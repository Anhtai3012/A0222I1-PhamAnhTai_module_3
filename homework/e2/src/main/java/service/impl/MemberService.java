package service.impl;

import model.Member;
import repository.IMemberRepository;
import repository.impl.MemberRepository;
import service.IMemberService;

import java.util.List;

public class MemberService implements IMemberService {
    IMemberRepository iMemberRepository = new MemberRepository();
    @Override
    public List<Member> selectAll() {
        return iMemberRepository.selectAll();
    }
}
