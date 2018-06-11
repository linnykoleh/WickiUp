package com.learning.linnyk.sp.part1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author LinnykOleh
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

	Class newImpl();
}
