package com.rein.service;

import com.rein.entity.Member;
import com.rein.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    public boolean memberDupValidation(String email) {
        Member findMember = memberRepository.findByEmail(email);
        if (findMember != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
