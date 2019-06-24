package com.ljw.vo;

import java.io.Serializable;
import java.util.Date;

public class MediaConf implements Serializable {
	private static final long serialVersionUID = 3511375457229660227L;

	private Long fileid;
	private String mediaType;
	private String usageCode;
	private String codeRate;
	private String container;
	
	private String lowestNetType;
	private String isAudio;
	private String isLive;
	private String isDown;
	private String filters;

	private Date createTime;
	private String createUser;
	private Date updateTime;
	private String updateUser;

	public Long getFileid() {
		return fileid;
	}

	public void setFileid(Long fileid) {
		this.fileid = fileid;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	public String getCodeRate() {
		return codeRate;
	}

	public void setCodeRate(String codeRate) {
		this.codeRate = codeRate;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getLowestNetType() {
		return lowestNetType;
	}

	public void setLowestNetType(String lowestNetType) {
		this.lowestNetType = lowestNetType;
	}

	public String getIsAudio() {
		return isAudio;
	}

	public void setIsAudio(String isAudio) {
		this.isAudio = isAudio;
	}

	public String getIsLive() {
		return isLive;
	}

	public void setIsLive(String isLive) {
		this.isLive = isLive;
	}

	public String getIsDown() {
		return isDown;
	}

	public void setIsDown(String isDown) {
		this.isDown = isDown;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeRate == null) ? 0 : codeRate.hashCode());
		result = prime * result + ((container == null) ? 0 : container.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((filters == null) ? 0 : filters.hashCode());
		result = prime * result + ((fileid == null) ? 0 : fileid.hashCode());
		result = prime * result + ((isAudio == null) ? 0 : isAudio.hashCode());
		result = prime * result + ((isDown == null) ? 0 : isDown.hashCode());
		result = prime * result + ((isLive == null) ? 0 : isLive.hashCode());
		result = prime * result + ((lowestNetType == null) ? 0 : lowestNetType.hashCode());
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((usageCode == null) ? 0 : usageCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MediaConf other = (MediaConf) obj;
		if (codeRate == null) {
			if (other.codeRate != null)
				return false;
		} else if (!codeRate.equals(other.codeRate))
			return false;
		if (container == null) {
			if (other.container != null)
				return false;
		} else if (!container.equals(other.container))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (filters == null) {
			if (other.filters != null)
				return false;
		} else if (!filters.equals(other.filters))
			return false;
		if (fileid == null) {
			if (other.fileid != null)
				return false;
		} else if (!fileid.equals(other.fileid))
			return false;
		if (isAudio == null) {
			if (other.isAudio != null)
				return false;
		} else if (!isAudio.equals(other.isAudio))
			return false;
		if (isDown == null) {
			if (other.isDown != null)
				return false;
		} else if (!isDown.equals(other.isDown))
			return false;
		if (isLive == null) {
			if (other.isLive != null)
				return false;
		} else if (!isLive.equals(other.isLive))
			return false;
		if (lowestNetType == null) {
			if (other.lowestNetType != null)
				return false;
		} else if (!lowestNetType.equals(other.lowestNetType))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (usageCode == null) {
			if (other.usageCode != null)
				return false;
		} else if (!usageCode.equals(other.usageCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MediaFile [fileid=" + fileid + ", mediaType=" + mediaType + ", usageCode=" + usageCode + ", codeRate="
				+ codeRate + ", container=" + container + ", lowestNetType=" + lowestNetType + ", isAudio=" + isAudio
				+ ", isLive=" + isLive + ", isDown=" + isDown + ", filters=" + filters + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", updateTime=" + updateTime + ", updateUser=" + updateUser + "]";
	}

}
