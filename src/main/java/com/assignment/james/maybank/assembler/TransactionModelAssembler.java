package com.assignment.james.maybank.assembler;

import com.assignment.james.maybank.controller.TransactionController;
import com.assignment.james.maybank.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class TransactionModelAssembler implements RepresentationModelAssembler<Transaction, EntityModel<Transaction>> {

    @Override
    public EntityModel<Transaction> toModel(Transaction transaction) {

        return EntityModel.of(transaction,
                linkTo(WebMvcLinkBuilder.methodOn(TransactionController.class).one(transaction.getId())).withSelfRel());
    }

    public EntityModel<Transaction> toModel(Transaction transaction, Pageable pageable) {

        return EntityModel.of(transaction,
                linkTo(WebMvcLinkBuilder.methodOn(TransactionController.class).one(transaction.getId())).withSelfRel(),
                linkTo(WebMvcLinkBuilder.methodOn(TransactionController.class).all(pageable)).withRel("all"));
    }
}