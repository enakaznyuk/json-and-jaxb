package com.solvd.metroxml.parse;

import com.solvd.metroxml.Metro;
import java.io.File;
import java.io.IOException;

public interface IPars {
    Metro parse(File file) throws IOException;
}
