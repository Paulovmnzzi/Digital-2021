package com.digitalers.parser;

import java.io.IOException;
import java.util.Collection;

import com.digitalers.domain.Articulos;

public interface IFileParser {

	public Collection<Articulos> parse() throws IOException;
}
