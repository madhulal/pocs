package org.mare.pos.service;

/**
 * Created by Madhulal M G on 10/10/15.
 */
import org.mare.pos.domain.CurrentUser;
import org.mare.pos.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.SUPER_ADMIN || currentUser.getId().equals(userId));
    }

}
