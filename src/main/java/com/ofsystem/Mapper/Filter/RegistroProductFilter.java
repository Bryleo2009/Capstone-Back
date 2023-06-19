package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroProductFilter {
    private Producto producto;

    //se modifico el tallacolorfilter aqui iba  private List<TallaColorFilter> tallaColorFilters;
    private TallaColorFilter tallaColorFilters;
}
