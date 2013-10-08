/**
 * Copyright: Copyright (c)2011
 * Company: im47.cn
 */
package cn.im47.utils.persistence;

/**
 * <p>Title: 版本化实体接口</p>
 * <p>Description: 所有要实现乐观锁的数据库实体实现该接口，泛型中转入实体ID类型</p>
 * <p>Copyright: Copyright (c)2011</p>
 * <p>Company: im47.cn</p>
 *
 * @author baitao.ji
 * @version 0.1, 13-3-22 下午9:19
 */
public interface VersionEntity<IDClass extends java.io.Serializable> extends Entity<IDClass> {

	public void setVersion(Long version);

	public Long getVersion();

}
