# Fruitier

Simple Fruitier ecommerce app to demonstrate the realtime capability of Supabase with Jetpack Compose.

## SQL

```sql
-- *** Table definitions ***

create table if not exists public.profiles (
    id uuid references auth.users on delete cascade not null primary key,
    user_name varchar(24) not null unique,
    first_name varchar(24) not null,
    last_name varchar(24) not null,
    email varchar(24) not null unique,
    created_at timestamp with time zone default timezone('utc' :: text, now()) not null,

    -- user_name should be 3 to 24 characters long containing alphabets, numbers and underscores
    constraint user_name_validation check (user_name ~* '^[A-Za-z0-9_]{3,24}$')
);
comment on table public.profiles is 'Holds all of users profile information';

create table if not exists public.orders (
    id uuid not null primary key default uuid_generate_v4(),
    user_id uuid default auth.uid() references public.profiles(id) on delete cascade not null,
    created_at timestamp with time zone default timezone('utc' :: text, now()) not null
);
comment on table public.orders is 'Holds individual placed.';

-- *** Add tables to the publication to enable realtime ***
alter publication supabase_realtime add table public.orders;


-- Function to create a new row in profiles table upon signup
-- Also copies the username value from metadata
create or replace function handle_new_user() returns trigger as $$
    begin
        insert into public.profiles(id, user_name, first_name, last_name, email)
        values(
            new.id,
            new.raw_user_meta_data->>'user_name',
            new.raw_user_meta_data->>'first_name',
            new.raw_user_meta_data->>'last_name',
            new.email,
        );

        return new;
    end;
$$ language plpgsql security definer;

-- Trigger to call `handle_new_user` when new user signs up
create trigger on_auth_user_created
    after insert on auth.users
    for each row
    execute function handle_new_user();
```