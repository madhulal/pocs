package org.mare.pos.repository;

import org.mare.pos.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Madhulal M G on 10/10/15.
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
