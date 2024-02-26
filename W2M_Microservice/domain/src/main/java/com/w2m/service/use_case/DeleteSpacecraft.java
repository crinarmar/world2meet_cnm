package com.w2m.service.use_case;

import com.w2m.service.Spacecraft;

public interface DeleteSpacecraft {

	void deleteSpacecraft(Long id);

	void deleteSpacecraft(Spacecraft spacecraft);
}
