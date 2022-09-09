package repository;

import model.Member;

import java.util.List;

public interface IMemberRepository {
    List<Member> selectAll();
}
