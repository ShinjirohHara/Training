package ch04.ex04_04;

interface Iterator<T> {}

interface Collection<E> extends Iterator<E> {}

interface Set<E> extends Collection<E> {}

interface List<E> extends Collection<E> {}


