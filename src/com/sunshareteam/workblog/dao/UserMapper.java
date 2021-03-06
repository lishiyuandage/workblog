package com.sunshareteam.workblog.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.sunshareteam.workblog.entity.admin;
import com.sunshareteam.workblog.entity.promission;
import com.sunshareteam.workblog.entity.role;

public interface UserMapper {
	
	@Select("select * from admin where usercode=#{adminid}")
	public admin findAdmin(String adminid);
	 
	@Select("select p.* from admin_role ar, admin a ,promission p , role_promission rp "
			+ "where rp.roleid=ar.id and rp.permissionid=p.id and ar.userid=a.id and a.usercode=#{adminid}")
	public List<promission> findPromission(String adminid);
	
	
	@Select("select r.*  from role r ,admin_role ar, admin a  where ar.role=r.id and ar.userid=a.id and a.usercode=#{adminid}")
	public List<role> findRole(String adminid);
	
}
