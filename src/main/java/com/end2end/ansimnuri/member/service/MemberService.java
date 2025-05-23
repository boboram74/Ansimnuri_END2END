package com.end2end.ansimnuri.member.service;

import com.end2end.ansimnuri.member.dto.LoginDTO;
import com.end2end.ansimnuri.member.dto.LoginResultDTO;
import com.end2end.ansimnuri.member.dto.MemberDTO;
import com.end2end.ansimnuri.member.dto.MemberUpdateDTO;

import java.util.List;

public interface MemberService {
    boolean isIdExist(String id);
    LoginResultDTO login(LoginDTO dto);
    void insert(MemberDTO dto);
    void update(MemberDTO dto);
    boolean isNickNameExist(String nickName);
    MemberDTO selectByLoginId(String loginId);
    MemberDTO updateMyInformation(String loginId, MemberUpdateDTO dto);
    boolean checkEmail(String email);
    void changePassword(String loginId, String pw);
    String getPw(String loginId);
    void deleteByLoginId(String loginId);
    void register(MemberDTO dto);
    void changeLoginIdByemail(String email, String pw);
    List<MemberDTO> getAllMembers();
    boolean checkPassword(String loginId, String password);
    boolean checkByKakaoId(String kakaoId);
    LoginResultDTO registerOAuthIfNeeded(String kakaoId, String nickname);
}
