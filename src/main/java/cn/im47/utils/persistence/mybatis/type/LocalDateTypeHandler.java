package cn.im47.utils.persistence.mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalDate;

import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c)2011</p>
 * <p>Company: im47.cn</p>
 *
 * @author baitao.ji
 * @version 0.1, 12-5-15 下午9:07
 */
@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler {

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	   */
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		LocalDate date = (LocalDate) parameter;
		if (date != null) {
			ps.setDate(i, new Date(date.toDateTimeAtStartOfDay().toDate().getTime()));
		} else {
			ps.setDate(i, null);
		}
	}

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
	   */
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Date date = rs.getDate(columnName);
		if (date != null) {
			return new LocalDate(date.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		Date date = rs.getDate(columnIndex);
		if (date != null) {
			return new LocalDate(date.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
	   */
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Date date = cs.getDate(columnIndex);
		if (date != null) {
			return new LocalDate(date.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}
}
