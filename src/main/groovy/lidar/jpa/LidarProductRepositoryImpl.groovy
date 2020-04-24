package lidar.jpa

import lidar.jpa.domain.LidarProduct
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Singleton
class LidarProductRepositoryImpl implements LidarProductRepository
{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	LidarProductRepositoryImpl( @CurrentSession EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional( readOnly = true )
	Optional<LidarProduct> findById( @NotNull Long id )
	{
		return Optional.ofNullable( entityManager.find( LidarProduct.class, id ) );
	}
	
	@Override
	@Transactional
	public LidarProduct save( @NotBlank String name )
	{
		LidarProduct lidarProduct = new LidarProduct( name );
		entityManager.persist( lidarProduct );
		return lidarProduct;
	}
}