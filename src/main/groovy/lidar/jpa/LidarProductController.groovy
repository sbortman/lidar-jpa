package lidar.jpa

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import lidar.jpa.domain.LidarProduct
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.HttpResponse;
import javax.validation.Valid;

@Controller( "/lidarProducts" )
class LidarProductController
{
	
	LidarProductRepository lidarProductRepository
	
	LidarProductController( LidarProductRepository lidarProductRepository )
	{
		this.lidarProductRepository = lidarProductRepository
	}
	
	@Get( "/{id}" )
	public LidarProduct show( Long id )
	{
		return lidarProductRepository
			.findById( id )
			.orElse( null );
	}
	
	@Post( "/" )
	public HttpResponse<LidarProduct> save( @Body @Valid LidarProductSaveCommand cmd )
	{
		LidarProduct lidarProduct = lidarProductRepository.save( cmd.name );
		
		return HttpResponse
			.created( lidarProduct )
//			.headers( { headers -> headers.location( location( lidarProduct.id ) ) });
	}
}