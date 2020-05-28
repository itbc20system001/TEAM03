package model;
import dao.MemberDAO;
public class ModifyUserInfoLogic {

	//DB内のユーザー情報を変更、成功/失敗を返す
	public static boolean modify(MemberBean oldMember,MemberBean newMember) {
		return new MemberDAO().modifyMember(oldMember, newMember);
	}
}
