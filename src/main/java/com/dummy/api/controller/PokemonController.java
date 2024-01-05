package com.dummy.api.controller;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonInsert;
import com.dummy.api.model.records.PokemonList;
import com.dummy.api.service.PokemonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokemons")
@Tag(name = "Pokemon")
public class PokemonController {
    private final PokemonService service;

    // TODO: create a put request to update a pokemon evolution
    // TODO: customize examples for responses (e.g.: 404)

    @Operation(
            description = "This endpoint returns all pokemon stored in the database.",
            responses = {
                @ApiResponse(
                        description = "Success.",
                        responseCode = "200"
                )
            }
    )
    @GetMapping
    public List<PokemonList> findAll(){
        return service.findAll();
    }

    @Operation(
            description = "This endpoint returns a pokemon belonging to the given ID.",
            responses = {
                    @ApiResponse(
                            description = "Success.",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Pokemon not found or invalid ID.",
                            responseCode = "404"
                    )
            },
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Pokemon ID"
                    )
            }
    )
    @GetMapping("/{id}")
    public PokemonDTO findById(@PathVariable Long id){
        return service.findById(id);
     }

    @Operation(
            description = "This endpoint returns a list of all pokemon that have an advantage against the pokemon belonging to the given ID.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Pokemon ID"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success.",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Pokemon not found or invalid ID.",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("/{id}/counters")
    public List<PokemonList> findCounterPokemons(@PathVariable Long id){
        return service.findCounterPokemons(id);
    }


    @Operation(
            description = "This endpoint returns a list of all pokemon belonging to this type",
            parameters = {
                    @Parameter(
                            name = "type",
                            description = "Pokemon type",
                            example = "fire"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success.",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Non-Existent type.",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("/types/{type}")
    public List<PokemonList> findByType(@PathVariable String type){
        return service.findByType(type);
    }

    @Operation(
            description = "Endpoint to delete a pokemon.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Pokemon ID"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success.",
                            responseCode = "204"
                    ),
                    @ApiResponse(
                            description = "Pokemon not found or invalid ID.",
                            responseCode = "404"
                    ),
                    @ApiResponse(
                            description = "Deletion not allowed",
                            responseCode = "405"
                    )
            }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @Operation(
            description = "Endpoint to create a pokemon.",
            responses = {
                    @ApiResponse(
                            description = "Pokemon created.",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Pokemon already exists.",
                            responseCode = "409"
                    )
                    // TODO: create a response to invalidate the creation of a pokemon if the types do not exist
            }
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pokemon create(@RequestBody PokemonInsert obj){
        return service.create(obj);
    }
}
