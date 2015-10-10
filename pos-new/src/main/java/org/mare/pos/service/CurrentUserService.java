package org.mare.pos.service;

import org.mare.pos.domain.CurrentUser;

/**
 * Created by Madhulal M G on 10/10/15.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
