package cn.im47.utils.persistence.mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalDateTime;

import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c)2011</p>
 * <p>Company: im47.cn</p>
 *
 * @author baitao.ji
 * @version 0.1, 12-6-13 下午9:14
 */
@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler implements TypeHandler {

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	   */
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if (parameter != null) {
			ps.setTimestamp(i, new Timestamp(((LocalDateTime) parameter).toDateTime().getMillis()));
		} else {
			ps.setTimestamp(i, null);
		}
	}

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
	   */
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Timestamp ts = rs.getTimestamp(columnName);
		if (ts != null) {
			return new LocalDateTime(ts.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		Timestamp ts = rs.getTimestamp(columnIndex);
		if (ts != null) {
			return new LocalDateTime(ts.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	   * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
	   */
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Timestamp ts = cs.getTimestamp(columnIndex);
		if (ts != null) {
			return new LocalDateTime(ts.getTime());//DateTimeZone.UTC
		} else {
			return null;
		}
	}
}
