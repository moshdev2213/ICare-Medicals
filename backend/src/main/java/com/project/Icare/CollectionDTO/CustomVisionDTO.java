package com.project.Icare.CollectionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomVisionDTO {
	private String id;
    private String project;
    private String iteration;
    private String created;
    private Prediction[] predictions;
   
    @Data
    @AllArgsConstructor
    public static class Prediction {
    	  private String probability;
    	    private String tagId;
    	    private String tagName;

    }
}
