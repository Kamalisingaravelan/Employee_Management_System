package com.anudip.empsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDTO {

		private Long id;

	    @NotBlank(message = "Department name is required")
	    private String name;

	    private String location;

		public DepartmentDTO() {
		
		}

		public DepartmentDTO(Long id, @NotBlank(message = "Department name is required") String name, String location) {
			super();
			this.id = id;
			this.name = name;
			this.location = location;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		@Override
		public String toString() {
			return "DepartmentDTO [id=" + id + ", name=" + name + ", location=" + location + "]";
		}
	    
	    
}
