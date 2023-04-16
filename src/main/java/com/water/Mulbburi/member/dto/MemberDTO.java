package com.water.Mulbburi.member.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.water.Mulbburi.file.FileDTO;

import lombok.Data;

@Data
public class MemberDTO implements UserDetails {
	
    private Long memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String phone;
    private String postCode;
    private String dtAddress;
    private String bsAddress;
    private String memberStatus;
    private String memberCustom;
    private String businessName;
    private String businessNo;
    private String email;
    private String cerNo;
    private List<MemberRoleDTO> memberRoleList;
    private List<FileDTO> fileList;
	
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<>();
		for(MemberRoleDTO role : memberRoleList) {
			roles.add(new SimpleGrantedAuthority(role.getAuthority().getName()));
		}
		return roles;
	}
	@Override
	public String getPassword() {

		return memberPwd;
	}
	@Override
	public String getUsername() {

		return memberId;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
}
