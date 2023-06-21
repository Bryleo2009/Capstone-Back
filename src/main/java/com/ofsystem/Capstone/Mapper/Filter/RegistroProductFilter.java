package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroProductFilter {
    private Producto producto;
    private List<TallaColorFilter> tallaColorFilters;
}
