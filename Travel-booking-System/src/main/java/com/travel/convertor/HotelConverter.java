package com.travel.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.travel.entity.Hotel;
import com.travel.model.HotelDTO;


@Component
public class HotelConverter {
	
	//converts from HotelConverter  entity to hotelDTO
			public HotelDTO convertEntityToHotelConverter(Hotel hot) {
				HotelDTO hotDTO = new HotelDTO();
				if(hot!=null)
				{
					BeanUtils.copyProperties(hot, hotDTO);
				}
				return hotDTO;
			}
			
			//converts from hotelDTO to hotel entity
			public Hotel  convertDTOToHotel(HotelDTO hotDTO)
			{
				Hotel hot = new Hotel();
				if(hotDTO!= null) {
					BeanUtils.copyProperties(hotDTO, hot);
					
				}
				return hot;
			}
}
