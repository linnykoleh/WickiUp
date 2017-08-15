package com.learning.linnyk.sp.part1;

/**
 * @author LinnykOleh
 */
public class ProfilingController implements  ProfilingControllerMBean{

	private boolean enabled = true;

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
