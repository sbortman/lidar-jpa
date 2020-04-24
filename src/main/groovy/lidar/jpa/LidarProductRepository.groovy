package lidar.jpa

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import lidar.jpa.domain.LidarProduct

interface LidarProductRepository {
	Optional<LidarProduct> findById(@NotNull Long id);
	LidarProduct save(@NotBlank String name);
	
}