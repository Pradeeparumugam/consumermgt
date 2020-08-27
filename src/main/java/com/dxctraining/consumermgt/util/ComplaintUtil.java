package com.dxctraining.complaintmgt.util;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.entities.Complaint;

public class ComplaintUtil {
	public ComplaintDto complaintdto(Complaint c) {
		ComplaintDto dto=new ComplaintDto(c.getId(),c.getDesc());
		return dto;
		
	}

}
