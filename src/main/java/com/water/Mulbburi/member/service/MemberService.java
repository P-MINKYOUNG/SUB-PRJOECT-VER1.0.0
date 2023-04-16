package com.water.Mulbburi.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.member.dao.MemberMapper;
import com.water.Mulbburi.member.dto.MemberDTO;
import com.water.Mulbburi.member.dto.MemberOrderDTO;
import com.water.Mulbburi.member.exception.MemberModifyException;
import com.water.Mulbburi.member.exception.MemberRegistException;
import com.water.Mulbburi.member.exception.MemberRemoveException;

@Service
@Transactional
public class MemberService {

	private final MemberMapper mapper;

    public MemberService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    public boolean selectMemberById(String userId) {

        String result = mapper.selectMemberById(userId);

        return result != null ? true : false;
    }

    public void registConMember(MemberDTO member) throws MemberRegistException{

        int result1 = mapper.insertConMember(member);
        int result2 = mapper.insertConMemberRole();


        if(!(result1 > 0 && result2 > 0)){
            throw new MemberRegistException("회원 가입에 실패하였습니다.");
        }
    }
    
    public void registSelMember(MemberDTO member, FileDTO fileDTO) throws MemberRegistException{

        int result1 = mapper.insertSelMember(member);
        int result2 = mapper.insertSelMemberRole();
        int result3 = mapper.insertFile(fileDTO);

        if(!(result1 > 0 && result2 > 0)){
            throw new MemberRegistException("회원 가입에 실패하였습니다.");
        }
    }

    public void modifyMember(MemberDTO member) throws MemberModifyException {
        int result = mapper.updateMember(member);

        if(!(result > 0)) {
            throw new MemberModifyException("회원 정보 수정에 실패하셨습니다.");
        }
    }

    public void removeMember(MemberDTO member) throws MemberRemoveException {
        int result = mapper.deleteMember(member);

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패하셨습니다.");
        }
    }

	public String findLoginId(MemberDTO member) {
		
		System.out.println("memberService : " + member);
		
		return mapper.findLoginId(member);
	}

	public String findLoginPwd(MemberDTO member) {
		
		return mapper.findLoginPwd(member);
	}
//	public int idCheck(String memberId) {
//		
//		return mapper.idCheck(memberId);
//		
//	}

	public void pwdModifyMember(MemberDTO member) {
		
		int result = mapper.pwdModifyMember(member);
		
	}

	public String findPwd(MemberDTO member) {
		
		
		return mapper.findPwd(member);
		
	}
	
}
