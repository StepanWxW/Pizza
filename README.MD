# Техническое задание.
# Описание

Этот репозиторий содержит код для мобильного приложения, которое предоставляет пользователю возможность просматривать информацию о пиццерии.
- Прототип дизайна находится по ссылке в [Figma](https://www.figma.com/file/8FvAWXCD2oD9oSDHx9xFfU/%D0%A2%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%BE%D0%B5-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-Android?node-id=0%3A1&mode=dev).
  ![Скриншот фигма](https://github.com/StepanWxW/Hotel/blob/master/img/figma.png)
## Что надо сделать:


- Главный экран приложения доставки еды, дизайн по ссылке выше
- В баннеры можно захардкодить любые фото
- Основная задача - сделать идентичную планку с категориями и блок
  меню(Подсказка. Для реализации можно использовать
  CollapsingToolbarLayout)
- Планка с категориями при скролле должна прилипать к верхнему
  бару(для примера можно посмотреть приложение Додо Пицца).
- В качестве API использовать любой открытый источник подходящий под
  текущие нужды

  **Опционально:**
- Offline-режим: т.е. в случае, если нет доступа к сети, показывать
  последние загруженные данные(и ленту, и детали).

### Ограничения на стек технологий:

- MVVM
- Clean Architecture
- Остальное на ваше усмотрение

## Реализация

### Использованные технологии:

- Kotlin
- Coroutines
- LiveData
- MVVM
- Room
- Clean Architecture
- Retrofit


[![Видео работы приложения]](https://youtu.be/hsezaVmzrs0)