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
public class VersionEntity extends Entity {

	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
