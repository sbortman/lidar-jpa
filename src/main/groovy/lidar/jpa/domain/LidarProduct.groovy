package lidar.jpa.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull

@Entity
@Table( name = "lidar_product" )
class LidarProduct
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	Long id
	
	@NotNull
	@Column( name = "name", nullable = false, unique = true )
	String name
	
	LidarProduct( String name=null )
	{
		this.name = name
	}
}