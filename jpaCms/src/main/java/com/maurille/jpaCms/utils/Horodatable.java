package com.maurille.jpaCms.utils;

import java.time.LocalDateTime;

public interface Horodatable {
	void setDateCreation(LocalDateTime date);
	void setDateEdition(LocalDateTime date);
}
