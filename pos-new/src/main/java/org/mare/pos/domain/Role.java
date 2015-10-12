package org.mare.pos.domain;

/**
 * Created by Madhulal M G on 10/10/15.
 */
public enum Role {

    USER(0), STORE_ADMIN(1), ORGANIZATION_ADMIN(2), SUPER_ADMIN(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
