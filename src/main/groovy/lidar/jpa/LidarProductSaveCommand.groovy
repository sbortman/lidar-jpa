package lidar.jpa

import javax.validation.constraints.NotBlank;
import io.micronaut.core.annotation.Introspected;

@Introspected
class LidarProductSaveCommand {
	@NotBlank
	String name;
	
	LidarProductSaveCommand(String name ){
		this.name = name
	}
	
}