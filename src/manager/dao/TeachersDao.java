package manager.dao;

import java.util.List;

import manager.bean.Teachers;
//模块的功能
public interface TeachersDao {
	public int addTeacher(Teachers t);
	public int delTeacher(Teachers t);
	public int updateTeachers(Teachers t);
	public Teachers findTeacher(Teachers s);
	public Teachers findTeacher(int s_id);
	public List<Teachers> findTeachers(Object...param);//参数个数、类型不确定

}
