package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.controller.exception.RoomNotFound;
import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public Room getRoomById(Long id) throws RoomNotFound {
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFound("There's no room with this id."));
    }

    public void updateRoomById(Long id, Room updatedRoom) throws RoomNotFound {
        Room roomToUpdate = roomRepository.findById(id).orElseThrow(() -> new RoomNotFound("There's no room with this id."));
        roomToUpdate.setCapacity(updatedRoom.getCapacity());
        roomToUpdate.setResidents(updatedRoom.getResidents());
        roomRepository.save(roomToUpdate);
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }


}
