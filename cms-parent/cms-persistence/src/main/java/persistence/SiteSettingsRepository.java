package persistence;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import entities.SiteSettingsEntity;

public interface SiteSettingsRepository extends CrudRepository<SiteSettingsEntity, Serializable> {
	SiteSettingsEntity findByDeliveryUrl(String deliveryUrl);
}
